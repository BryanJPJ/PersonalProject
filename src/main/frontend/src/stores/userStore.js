import { defineStore } from 'pinia'
import { ref } from 'vue';

export const userStore = defineStore ('userStore', () => {
	const userObject = ref([]);
	return userObject
})