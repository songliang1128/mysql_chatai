<template>
  <Header />

  <div class="card-container" style="margin: 2% auto;width: 90vw;">
    <router-view/>
  </div>


</template>

<script setup>

import Header from '/src/components/header.vue'
import {onBeforeMount, onMounted, ref} from "vue";
import {getInfo} from "../api/user";
import {useStore} from "vuex";
import {getToken} from "../api/token";
const store = useStore();
const userData = ref(null);

onBeforeMount(async () => {
  if (getToken() !== null) {
    try {
      const response = await getInfo();
      store.commit('setUsername', response.data.data.username);
    } catch (error) {
      console.error('Error fetching user info', error);
    }
  }
})
</script>



<style scoped>
.card-container {
  display: flex;
  flex-direction: row; /* 横向排列 */
}
</style>