package br.com.dojo.jogo5A.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.dojo.jogo5A.service.impl.JogoServiceImpl;
import br.com.dojo.jogo5A.vo.PartidaVo;

@ManagedBean
@ViewScoped
public class JogoController {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		System.out.println("teste");
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String getHello() {
		return "Hello from PrimeFaces and Spring Boot!";
	}

	public List<PartidaVo> getListPartida() {
		List<PartidaVo> listaPartidaVo = new JogoServiceImpl().lerLog("logpartida.log");
		return listaPartidaVo;
	}

	public void doUpload(FileUploadEvent fileUploadEvent) { 
		UploadedFile uploadedFile = fileUploadEvent.getFile(); 
		String fileNameUploaded = uploadedFile.getFileName(); 
		long fileSizeUploaded = uploadedFile.getSize();  
		String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded +"</b><br/>"+ "Tamanho do Arquivo: <b>"		+fileSizeUploaded+"</b>"; 
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
		facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile)); }

}
