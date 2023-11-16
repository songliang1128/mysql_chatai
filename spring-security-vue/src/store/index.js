import {createStore} from "vuex";
import user from "./useStore/userModule";

const store = createStore({
    modules:{
        user,
    }
})

export default store;