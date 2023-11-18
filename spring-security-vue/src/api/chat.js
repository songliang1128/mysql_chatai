import request from './request'

export function getChatInfo(question, id){
    return request({
        url: '/api/user/sendQuestion',
        method: 'get',
        params:{
            question: question,
            uuid: id,
        }
    })
}

export function getChatCard(){
    return request({
        url: '/api/user/chat/get-list',
        method: 'get',
    })
}

export function addDialog(data){
    return request({
        url: '/api/user/chat',
        method: 'post',
        data,
    })
}

export function deleteDialog(uuid){
    return request({
        url: '/api/user/chat/delete/' + uuid,
        method: 'get',
    })
}

export function updateDialog(data){
    return request({
        url: '/api/user/chat/change',
        method: 'post',
        data,
    })
}

export function getBotInfo(uuid){
    return request({
        url: '/api/user/chat/getBotInfo',
        method: 'get',
        params: {
            uuid: uuid,
        }
    })
}

