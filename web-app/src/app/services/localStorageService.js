class localStorageService {
    ls = window.localStorage
  
    setItem(key, value) {
      value = JSON.stringify(value)
      this.ls.setItem(key, value)
      return true
    }
    
    getItem(key) {
      let value = document.cookie.indexOf(key)
      console.log("COOKIE",value);
      try {
        if(value > -1){
          return document.cookie[value]
        }else{
          return null;
        }
      } catch (e) {
        return null
      }
    }
  
    removeItem(key){
      try {
        this.ls.removeItem(key)
      } catch (e) {
        return null
      }
    }
  
  }
    
  export default new localStorageService();