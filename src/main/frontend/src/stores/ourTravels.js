import { defineStore } from 'pinia'
import { ref } from 'vue';

export const ourTravels = defineStore ('ourTravels', () => {
	const ourTravelsObject = ref([]);
	return ourTravelsObject;
})