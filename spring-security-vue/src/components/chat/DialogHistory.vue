<template>
  <el-scrollbar style="margin-top: 10px">
    <el-card @click="$emit('sendValue', digList.uuid)" v-for="digList in digLists" :key="digList" class="card" shadow="never">
      <span class="span-left">{{ digList.uuid }}.</span>
      <span style="margin-right: 50px">{{ digList.title }}</span>

      <div class="spacer"></div>

      <div class="no-wrap" @click="createDialogCopy(digList)">
        <el-icon ><Edit /></el-icon>
      </div>
      <div class="no-wrap" @click="deleteDia(digList.uuid)">
        <el-icon color="red"><Delete /></el-icon>
      </div>
    </el-card>
    <el-dialog v-model="centerDialogVisible" title="修改会话" width="30%" center>
      <el-form :model="newDigList">
        <el-form-item label="名字：" :label-width="formLabelWidth">
          <el-input v-model="newDigList.title" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button @click="updateDia(newDigList)" type="primary">
          确认
        </el-button>
      </span>
      </template>
    </el-dialog>
  </el-scrollbar>
</template>

<script setup>
import {computed, ref} from 'vue';
import { Delete, Edit } from '@element-plus/icons-vue';
import {deleteDialog, updateDialog} from "../../api/chat";

const props = defineProps(['digLists']);
const digLists = computed(() => {
      return props.digLists
})
const formLabelWidth = '140px'
const centerDialogVisible = ref(false)
const newDigList = ref({
  uuid: '',
  title: '',
});

function createDialogCopy(original){
  newDigList.value = original;
   centerDialogVisible.value = true;
}

function deleteDia(uuid){
    deleteDialog(uuid)
        .then(() =>{
          // 刷新当前页面
          location.reload();

        })
}

function updateDia(values){
  centerDialogVisible.value = false
  updateDialog(values)
      .then(() => {
      })

}


</script>

<style scoped>
.card{
  border-radius: 10px;
  margin-top: 10px;
  display: flex;
  width: 250px;
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
