<script setup>
import {onMounted, onUnmounted} from "vue";
import {reMoveToken} from "../api/token";
import {useRouter} from "vue-router";

const router = useRouter()
onMounted(() => {
  reMoveToken();
  router.push('/login')
})

</script>

<template>

</template>

<style scoped>

</style>