import { defineStore } from 'pinia'
import { ref } from 'vue';

export const imageUser = defineStore ('auth', () => {
	const userImageObject = ref([]);
	return userImageObject
})