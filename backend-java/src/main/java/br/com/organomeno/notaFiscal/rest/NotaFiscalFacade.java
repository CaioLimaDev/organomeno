package br.com.organomeno.notaFiscal.rest;

import br.com.organomeno.notaFiscal.entity.NotaFiscalFiltroDTO;
import br.com.organomeno.notaFiscal.services.NotaFiscalService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@ApplicationScoped
public class NotaFiscalFacade {

    @Inject
    NotaFiscalService notaFiscalService;

    public Response inserirNotaFiscalEItens(FileUpload htmlFile, String nomeArquivo) {
        try {
            return notaFiscalService.inserirNotaFiscal(htmlFile, nomeArquivo);
        } catch (Exception e) {
            return Response.serverError().entity("Erro ao inserir Nota Fiscal").build();
        }
    }

    public Response listarNotasFiscais(NotaFiscalFiltroDTO notaFiscalFiltroDTO) {
        return Response.ok(notaFiscalService.filtrarNotaFiscal(notaFiscalFiltroDTO)).build();
    }
}
