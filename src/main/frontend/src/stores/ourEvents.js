import { defineStore } from 'pinia'
import { ref } from 'vue';

export const ourEvents = defineStore ('ourEvents', () => {
	const ourEventsObject = ref([]);
	return ourEventsObject
})