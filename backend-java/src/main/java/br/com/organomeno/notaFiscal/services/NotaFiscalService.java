package br.com.organomeno.notaFiscal.services;

import br.com.organomeno.notaFiscal.entity.NotaFiscal;
import br.com.organomeno.notaFiscal.entity.NotaFiscalDTO;
import br.com.organomeno.notaFiscal.entity.NotaFiscalFiltroDTO;
import br.com.organomeno.scrapNotaFiscal.IdentificadorLayout;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.List;

public interface NotaFiscalService {

    List<NotaFiscalDTO> filtrarNotaFiscal(NotaFiscalFiltroDTO notaFiscalFiltroDTO);
    Response inserirNotaFiscal(FileUpload htmlFile, String descricaoArquivo ) throws Exception;
}
