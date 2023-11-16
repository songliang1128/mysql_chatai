import request from './request'

export function getChatInfo(params){
    return request({
        url: '/api/user/sendQuestion',
        method: 'get',
        params,
    })
}

export function getChatCard(){
    return request({
        url: '/api/user/chat/get-list',
        method: 'get',
    })
}

