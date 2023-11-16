<template>
  <el-card style="height: 38em; border-radius: 30px; width: 20%; margin-left: 5%" shadow="always">
    <el-button @click="createDia" round style="width: 90%; height: 3rem">
      <el-icon>
        <Plus />
      </el-icon>&nbsp;&nbsp;创建
    </el-button>
    <el-divider>
      <div style="color: rgb(128, 128, 128)">历史对话</div>
    </el-divider>
    <DialogHistory @send-value="sentValue" :digLists="digLists" />
  </el-card>
</template>

<script setup>
import {onMounted, ref} from 'vue';
import { Delete, Edit, Plus } from '@element-plus/icons-vue';
import DialogHistory from "./DialogHistory.vue";
import {addDialog, getChatCard} from "../../api/chat";

const emits = defineEmits(['someValues', 'delete']);
let uuid
const digLists = ref([]);
function sentValue(value){
    emits('someValues', value);
}

onMounted(() => {
    getChatCard()
        .then((response) => {
          digLists.value = response.data.data;
        })
        .catch((err) =>{
          console.log(err);
        })
})

function getUuid(){
  if(digLists.value.length === 0) uuid = 1;
  else  uuid = digLists.value[digLists.value.length - 1].uuid + 1;
}

function createDia() {

  getUuid();

  const newDialog = {
    uuid: uuid,
    title: '新建会话'
  }

  addDialog(newDialog)
      .then((response) =>{
        console.log(response)
      })
      .catch((err) => {
        console.log(err);
      })

  digLists.value.push({
    title: '新建会话',
    uuid:   uuid,
  });
  console.log(digLists.value);
}
</script>

<style scoped>
span {
  font-size: small;
  margin-left: 5px;
}


</style>
