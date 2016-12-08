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
    gender genderOfPeople;
    public Gender(){
        genderOfPeople=gender.undefied;
    };
    public void SetGenderToWoman(){
        genderOfPeople=gender.woman;
    }
    public void SetGenderToMan(){
        genderOfPeople=gender.man;
    }
    public String GenderText(){
        return this.genderOfPeople.toString();
    }
    public String GenderTextHeShe(){
        //Return string "he" or "she" according to gender. 
        return (genderOfPeople==gender.undefied) ? "(error: undefied gender-->she or he)" :(genderOfPeople==gender.woman? "she":"he");
    }
    public String GenderTextHisHer(){
        //Return string "his" or "her" according to gender.
        return (genderOfPeople==gender.undefied) ? "(error: undefied gender-->her or his)" :(genderOfPeople==gender.woman? "her":"his");
    }
            
}
