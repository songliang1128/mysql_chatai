import axios from 'axios'
import {getToken} from "./token";

const service = axios.create({
    timeout: 30000,
})

service.interceptors.request.use((config) => {
    if(getToken()){
        config.headers['Authorization'] = getToken();
    }
    return config;
})

export default service