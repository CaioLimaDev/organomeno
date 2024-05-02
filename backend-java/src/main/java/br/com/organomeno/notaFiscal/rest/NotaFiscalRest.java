package br.com.organomeno.notaFiscal.rest;

import br.com.organomeno.notaFiscal.entity.NotaFiscalDTO;
import br.com.organomeno.notaFiscal.entity.NotaFiscalFiltroDTO;
import br.com.organomeno.notaFiscal.services.NotaFiscalService;
import br.com.organomeno.scrapNotaFiscal.IdentificadorLayout;
import io.vertx.core.json.Json;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

@Path("/notas")
public class NotaFiscalRest {

    @Inject
    NotaFiscalFacade notaFiscalFacade;

    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response inserirNotaFiscalEItens(@RestForm("htmlFile") FileUpload htmlFile, @RestForm("nomeArquivo") String nomeArquivo) throws Exception {
        try {
            return notaFiscalFacade.inserirNotaFiscalEItens(htmlFile,nomeArquivo);
        }catch (Exception e){
            throw e;
        }
    }

    @GET
    @Path("/")
    public Response listarNotasFiscais(NotaFiscalFiltroDTO notaFiscalFiltroDTO){
        return notaFiscalFacade.listarNotasFiscais(notaFiscalFiltroDTO);
    }

}
