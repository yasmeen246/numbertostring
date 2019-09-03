package com.example.jasmn.numbertostring;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class MainActivity extends AppCompatActivity  {
EditText number_;
TextView words;
ArrayList<String> first=new ArrayList<>();
    ArrayList<String> second=new ArrayList<>();
    ArrayList<String> third=new ArrayList<>();
    ArrayList<String> second_=new ArrayList<>();
      List<String> [] all=new List[3];
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_=findViewById(R.id.num);
        words=findViewById(R.id.stingvalue);
    Collections.addAll(first,"","one","two","three","four","five","six","seven","eight","nine");
    Collections.addAll(second,"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen");
    Collections.addAll(second_,"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","nine");
    Collections.addAll(third,"","one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred");
    all[0]=first;
   all[1]=second_;
   all[2]=third;

}

    public void convert(View view) {
    words.setText("");
        String num= number_.getText().toString();
        String words_num;
        ArrayList<Character>nums=new ArrayList<>();
        List<Character>characters1;
        List<Character>characters2;

        for (int i = 0; i <num.length() ; i++) {
            nums.add(num.charAt(i));
            System.out.println(nums.get(i));
        }
        if (nums.contains('.')){

            characters1 =  nums.subList(0, nums.indexOf('.'));
            Collections.reverse(characters1);
            words_num  = data(characters1);
            characters2 = nums.subList( nums.indexOf('.')+1,nums.size());
            Collections.reverse(characters2);
            words_num  =words_num+" point "+ data(characters2);
        }
        else {
        Collections.reverse(nums);
        words_num  = data(nums);
      }

        words.setText(words_num);
      }

         String data(List<Character> list){
               int txt_num;
               String word_num = "";
               String thosu_num="";
             int j=0;
             for (int i = 0; i <list.size() ; i++) {
                 txt_num=Integer.parseInt(String.valueOf(list.get(i)));
                 if (list.size()>8) {
                     Toast.makeText(this, "BIG NUMBER!!!!!", Toast.LENGTH_SHORT).show();
                     break;
                 }
                 if (list.size()==1 && txt_num==0){
                     word_num="zero";
                 }
                 if (i==1&&txt_num==1){
                     word_num=second.get(Integer.parseInt(String.valueOf(list.get(i-1))));

                 }else if (i<3){
                 word_num=all[i].get(txt_num)+" "+word_num;
             }

             else if (i>2 && i <6 ){
                     if (txt_num !=0){
                     if (j==1&&txt_num==1){
                         thosu_num=second.get(Integer.parseInt(String.valueOf(list.get(i-1))));
                     }
                     else
                     thosu_num=all[j].get(txt_num)+" "+thosu_num;
                     j++;
                     if (i==5 || i==list.size()-1){
                         word_num= thosu_num+" thousand  "+word_num;
                         j=0;
                         thosu_num="";
                     }}

                 }
                 else if (i>5&& i<9) {
                     if (j==1&&txt_num==1){
                         thosu_num=second.get(Integer.parseInt(String.valueOf(list.get(i-1))));
                     }
                     else
                         thosu_num=all[j].get(txt_num)+" "+thosu_num;
                     j++;
                     if (i==list.size()-1){
                         word_num= thosu_num+" million  "+word_num;
                         j=0;
                         thosu_num="";
                     }
                 }
             }
           return word_num;
         }}
