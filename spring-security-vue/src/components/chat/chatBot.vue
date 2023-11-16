<script setup>

import {computed, nextTick, ref} from "vue";
import {getNowDayTime} from "../../api/api";
import store from "../../store";
const props = defineProps(['id'])
const scrollbarRef = ref();
const textarea = ref('');

const Submit = () =>{
  dialogList.value.push(
      {
        role: 'user',
        time: getNowDayTime(),
        content: textarea.value
      })
}

const dialogList = ref([
  {
    role: 'assistant',
    time: '2023-11-15 17:34:21',
    content: '你好'
  },
  {
    role: 'user',
    time: '2023-11-15 17:34:21',
    content: '你好呀'
  }
]);


const id = computed(() => {
  return props.id;
})

const DownScrollBar = () => {
  nextTick(() => {
    let scrollBar = document.getElementById("scrollBar");
    scrollbarRef.value.setScrollTop(scrollBar.scrollHeight);
  });
}

</script>

<template>
  <el-row style="width: 60%; margin-left: 5%; height: 27.5em; border-radius: 30px">
    <el-col>
      <el-card style=" height: 27.5em; border-radius: 30px" shadow="always">
        <el-scrollbar ref="scrollbarRef" id="scrollBar" style=" height: 25em;padding-right: 10px">
          <div v-for="dialog in dialogList" v-bind:key="dialog">
            <div class="gpt" v-if="dialog.role==='assistant'">
              <div class="gpt-name">
                <img src="../../assets/img.png" alt="无法显示">
                <span class="date">
              {{
                    dialog.time
                  }}
            </span>
              </div>
              <div class="gpt-message">
                {{
                  dialog.content
                }}
              </div>
            </div>
            <div class="user" v-if="dialog.role==='user'">
              <div class="user-name">
            <span>
              {{
                store.getters.getInfo
              }}
            </span>
                <span class="date">
              {{
                    dialog.time
                  }}
            </span>
              </div>
              <div class="user-message">
                {{
                  dialog.content
                }}
              </div>
            </div>
          </div>
        </el-scrollbar>
      </el-card>
    </el-col>
    <el-col>
      <el-card shadow="always" style="margin-top: 1%; border-radius: 30px; height: 10em" >
        <el-input
            :rows="4"
            v-model="textarea"
            type="textarea"
            placeholder="请输入你想问的问题"
            v-on:keyup.shift.enter="Submit"
            autofocus
        />
        <el-button style="float: right; margin-top: 7px; width: 10%" round @click="Submit">提交
        </el-button>
      </el-card>
    </el-col>
  </el-row>

</template>

<style scoped>
img{
  width: 25px;
  height: 25px;
}
.gpt-name {
  font-size: large;
  font-weight: bold;
  color: cornflowerblue;
}
.gpt {
  width: 100%;
  float: left;
}
.gpt-message {
  background-color: whitesmoke;
  max-width: 60%;
  width: fit-content;
  margin: 10px;
  padding: 5px;
  border-radius: 5px;
}
.date {
  font-size: 70%;
  color: rgb(128, 128, 128);
  margin-left: 10px;
}
.user {
  width: 100%;
  float: right;
  text-align: right;
}

.user-name {
  font-size: large;
  font-weight: bold;
  color: forestgreen;
  margin-right: 10px;
}

.user-message {
  background-color: whitesmoke;
  max-width: 60%;
  width: fit-content;
  margin: 10px;
  padding: 5px;
  border-radius: 5px;
  float: right;
  text-align: left;
}

</style>