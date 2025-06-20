const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyaunshiwuzhaolingxitong/",
            name: "xiaoyaunshiwuzhaolingxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyaunshiwuzhaolingxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园失物招领系统"
        } 
    }
}
export default base
