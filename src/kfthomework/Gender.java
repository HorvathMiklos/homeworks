/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

/**
 *
 * @author mhorvath
 */
public class Gender {
    private enum gender{woman,man,undefied};
    gender genderOfPerson;
    public Gender(){
        genderOfPerson=gender.undefied;
    };
    public void setGenderToWoman(){
        genderOfPerson=gender.woman;
    }
    public void setGenderToMan(){
        genderOfPerson=gender.man;
    }
    public String genderText(){
        return this.genderOfPerson.toString();
    }
    public String genderTextHeShe(){
        //Return string "he" or "she" according to gender. 
        return (genderOfPerson==gender.undefied) ? "(error: undefied gender-->she or he)" :(genderOfPerson==gender.woman? "she":"he");
    }
    public String genderTextHisHer(){
        if(genderOfPerson!=gender.undefied){
            return genderOfPerson==gender.woman? "her":"his";
        }
        else{
            return "(error: undefied gender-->her or his)";
        }
    }
    public String qenderTextHimHer(){
        if(genderOfPerson!=gender.undefied){
            return genderOfPerson==gender.woman? "her":"him";
        }
        else{
            return "(error: undefied gender-->her or him)";
        }
    }
            
}
