package com.example.project_spring_conn;

public class BoardData {

    private int num;
    private String m_id;
    private String subject;
    private String content;
    //private MultipartFile filename;
    //private String attached_file;
//    private int answer_num;
//    private int answer_lev;
//    private int answer_seq;
//    private int read_count;
    //private Date write_date;
    private String write_date;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public int getAnswer_num() {
//        return answer_num;
//    }
//
//    public void setAnswer_num(int answer_num) {
//        this.answer_num = answer_num;
//    }
//
//    public int getAnswer_lev() {
//        return answer_lev;
//    }
//
//    public void setAnswer_lev(int answer_lev) {
//        this.answer_lev = answer_lev;
//    }
//
//    public int getAnswer_seq() {
//        return answer_seq;
//    }
//
//    public void setAnswer_seq(int answer_seq) {
//        this.answer_seq = answer_seq;
//    }
//
//    public int getRead_count() {
//        return read_count;
//    }
//
//    public void setRead_count(int read_count) {
//        this.read_count = read_count;
//    }
//
    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }
}
