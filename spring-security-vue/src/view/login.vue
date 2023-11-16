<template>

  <el-card >
    <el-form label-width="80px">
      <el-form-item label="用户名：">
        <el-input v-model="data.username" placeholder="请输入用户名"  name="username" >
          <template #prefix>
            <el-icon>
              <User/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>

      <el-form-item label="密码：">
        <el-input type="password" v-model="data.password" placeholder="请输入密码"  name="password" >
          <template #prefix>
            <el-icon>
              <Lock/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="Dologin">登陆</el-button>
        <el-button>注册</el-button>
      </el-form-item>

    </el-form>
  </el-card>
</template>

<script setup>
import {ref} from 'vue'

import {login} from "../api/user";
import {setToken} from "../api/token";
import {useRouter} from "vue-router";
import {Lock, User} from "@element-plus/icons-vue";

const data = ref({
    username: '',
    password: '',
})

const router = useRouter();

function Dologin(){

    login(data.value)
        .then(response =>{
          setToken("Bearer " + response.data)
          router.push('/')
        })
}

</script>


<style scoped>
.el-card {
  width: 400px;
  margin: 30vh auto;
}
</style>