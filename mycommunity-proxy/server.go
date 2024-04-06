package main

import (
  "log"
  "net/http"
  "github.com/gin-gonic/gin"
)

// User 结构体用于存储 POST 请求中的参数
type User struct {
  Email  string `json:"email" binding:"required"`
  Uuid  string `json:"uuid" binding:"required"`
}

func setupRouter() *gin.Engine {

  r := gin.Default()

  r.POST("/user", func(c *gin.Context) {
    var user User
    err := c.BindJSON(&user)
    if(err != nil){
      c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
      return
    }
    log.Printf("add user, email:%s id:%s", user.Email, user.Uuid)
    err = addUser(user.Email,user.Uuid)
    if(err != nil){
      c.JSON(http.StatusOK, gin.H{"error": err})
    }else{
      c.JSON(http.StatusOK, gin.H{"email":user.Email, "uuid": user.Uuid})
    }
  })
  
  r.DELETE("/user/:email", func(c *gin.Context) {
    email := c.Params.ByName("email")
    log.Printf("remove user, email:%s",email)
    err := removeUser(email)
    if(err != nil){
      c.JSON(http.StatusOK, gin.H{"error": err})
    }else{
      c.JSON(http.StatusOK, gin.H{"email":email})
    }
  })

  return r
  
}

func main() {
  r := setupRouter()
  // Listen and Server in 0.0.0.0:8080
  r.Run(":8080")
}