package com.example.website;

public class MovieModelClass {
    String name;
    String fullname;
    String login;
    String description;
    String img;
    Boolean toggle1;
    Boolean toggle2;
    String url;
    String officon;

    public MovieModelClass(String name, String fullname, String description, String img, Boolean toggle1,Boolean toggle2){
        this.name=name;
        this.fullname=fullname;
        this.description=description;
        this.img=img;
        this.toggle1=toggle1;
        this.toggle2=toggle2;


    }

    public MovieModelClass(){

    }

    public  String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }

    public  String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname){
        this.fullname= fullname;
    }

    public  String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description= description;
    }

    public  String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img= img;
    }


    public  Boolean getToggle1(){
        return toggle1;
    }
    public Boolean setToggle1(Boolean toggle1)
    {
        this.toggle1= toggle1;
        return toggle1;
    }


    public Boolean getToggle2(){
        return toggle2;
    }

    public Boolean setToggle2(Boolean toggle2){
        this.toggle2= toggle2;
        return toggle2;
    }

    public  String getLogin(){ return login; }
    public void setLogin(String login){
        this.login= login;
    }

    public  String getExtraurl(){
        return url;
    }
    public void setExtraurl(String url){
        this.url= url;
    }







}
