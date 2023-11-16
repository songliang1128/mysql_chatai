<template>
  <el-scrollbar style="margin-top: 10px">
    <el-card @click="$emit('sendValue', digList.uuid)" v-for="digList in digLists" :key="digList" class="card" shadow="never">
      <span class="span-left">{{ digList.uuid }}.</span>
      <span style="margin-right: 30px">{{ digList.title }}</span>

      <div class="spacer"></div>

      <div class="no-wrap" @click="centerDialogVisible = true">
        <el-icon><Edit /></el-icon>
      </div>
      <el-dialog v-model="centerDialogVisible" title="修改会话" width="30%" center>
        <el-form :model="digList">
          <el-form-item label="名字：" :label-width="formLabelWidth">
            <el-input v-model="digList.title" autocomplete="off" />
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="centerDialogVisible = false">
          确认
        </el-button>
      </span>
        </template>
      </el-dialog>

      <div class="no-wrap" @click="deleteDia">
        <el-icon color="red"><Delete /></el-icon>
      </div>
    </el-card>
  </el-scrollbar>
</template>

<script setup>
import {computed, ref} from 'vue';
import { Delete, Edit } from '@element-plus/icons-vue';

const props = defineProps(['digLists']);
const digLists = computed(() => {
      return props.digLists
})
const formLabelWidth = '140px'
const centerDialogVisible = ref(false)
function deleteDia(){
    digLists.value.pop();
}


</script>

<style scoped>
.card{
  border-radius: 10px;
  margin-top: 10px;
  display: flex;
  width: 98%;
}

span {
  font-size: small;
  margin-left: 5px;
}
.span-left {
  margin-left: 15px;
}
.no-wrap {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  font-size: small;
  width: 23px;
  height: 23px;
  border: 1px solid #c8c9cc;
  border-radius: 50%;
  margin-left: 5px;
  text-align: right;
}

.spacer {
  display: inline-flex;
  flex-grow: 1;
  min-width: 10px;
}
</style>
