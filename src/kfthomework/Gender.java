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
        //Return string "his" or "her" according to gender.
        return (genderOfPerson==gender.undefied) ? "(error: undefied gender-->her or his)" :(genderOfPerson==gender.woman? "her":"his");
    }
    public String qenderTextHimHer(){
        //Return string "him" or "her" according to gender.
        return (genderOfPerson==gender.undefied) ? "(error: undefied gender-->her or his)" :(genderOfPerson==gender.woman? "her":"him");
    }
            
}
