package com.example.Examen4B.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateReportDTO {

    //Validaciones
    @NotBlank (message = "El nombre del prducto es obligatorio")
    private String productName;

    @NotBlank (message = "La descripcion del problema es obligatorio")
    private String problemDescription;

    @NotBlank (message = "La fecha del reporte es obligatoria")
    private String reportDate;


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

}