import { defineStore } from 'pinia'
import { ref } from 'vue';

export const imageOurEvents = defineStore ('auth', () => {
	const ourEventsImageObject = ref([]);
	return ourEventsImageObject
})