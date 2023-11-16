export function setToken(token){
    localStorage.setItem("token", token);
}

export function getToken(){
   return  localStorage.getItem("token");
}

export function reMoveToken() {
    localStorage.removeItem("token");
}