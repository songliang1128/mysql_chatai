<script setup xmlns="http://www.w3.org/1999/html">

import {Search, StarFilled} from "@element-plus/icons-vue";
import {ref} from "vue";

const value = ref('')

const options = [
  {
    value: '积分任务',
    label: '积分任务',
  },
  {
    value: '会员任务',
    label: '会员任务',
  },
]

</script>

<template>

  <el-card style="height: 45em; width: 100em">
    <span style="margin-left: 43%; font-size: 50px">任务大厅</span>
    <el-divider>
      <el-icon><star-filled /></el-icon>
    </el-divider>

    <div style="display: flex; align-items: center;">
      <el-input
          style="margin-bottom: 20px; width: 10vw"
          v-model="input2"
          class="w-50 m-2"
          placeholder="任务名称"
          :prefix-icon="Search"
      />

      <el-select
          style="margin-bottom: 20px; width: 10vw; margin-left: 15px"
          v-model="value"
          class="m-2"
          placeholder="Select"
      >
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
        />
      </el-select>

      <el-button type="primary" style="margin-left: 15px; margin-bottom: 17px">搜索</el-button>
    </div>



    <el-row :gutter="20">
      <el-col :span="6">
        <el-card class="box-card">
          1234
        </el-card>
      </el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
      <el-col :span="6">
        <el-card class="box-card">
          1234
        </el-card>
      </el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
      <el-col :span="6"><el-card class="box-card">
        1234
      </el-card></el-col>
    </el-row>

    <el-pagination style="text-align: right;" background layout="prev, pager, next" :total="100" />
  </el-card>
</template>

<style scoped>

.box-card{
  height: 200px;
  margin-bottom: 30px;
}

.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>