package com.example.Examen4B.model;

public class Report {

    private Long id;
    private String productName;
    private String problemDescription;
    private String reportDate;
    private boolean resolved = false;


    //Constructor vacio para JSON
    public Report() {}

    //Constructor con prametros
    public Report(Long id, String productName, String problemDescription, String reportDate) {
        this.id = id;
        this.productName = productName;
        this.problemDescription = problemDescription;
        this.reportDate = reportDate;
    }

    //Getters y Setters
    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }



    public String getProductName() {
        return productName; }
    public void setProductName(String productName) {
        this.productName = productName; }



    public String getProblemDescription() {
        return problemDescription; }
    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription; }



    public String getReportDate() {
        return reportDate; }
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate; }



    public boolean isResolved() {
        return resolved; }
    public void setResolved(boolean resolved) {
        this.resolved = resolved; }

}

