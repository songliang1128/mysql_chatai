import request from './request.js'

function login(data){
    return request({
        url: '/api/user/login',
        method: 'post',
        data,
        headers: {'Content-Type':'application/json'}
    })
}

function getInfo(){
    return request({
        url: '/api/user/getInfo',
        method: 'get',
    })
}

export {login, getInfo}