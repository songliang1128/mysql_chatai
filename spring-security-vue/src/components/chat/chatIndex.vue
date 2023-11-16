<script setup>

import ChatNavigate from "./chatNaviga.vue";
import ChatBot from "./chatBot.vue";
import {ref} from "vue";
const id = ref(1)

function someValues(value){
    id.value = value;
}
</script>

<template>

  <ChatNavigate @some-values="someValues" />
  <chat-bot :id="id" />
</template>

<style scoped>

</style>