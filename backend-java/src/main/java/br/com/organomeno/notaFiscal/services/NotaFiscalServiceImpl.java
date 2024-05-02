package br.com.organomeno.notaFiscal.services;

import br.com.organomeno.notaFiscal.entity.NotaFiscal;
import br.com.organomeno.notaFiscal.entity.NotaFiscalDTO;
import br.com.organomeno.notaFiscal.entity.NotaFiscalFiltroDTO;
import br.com.organomeno.notaFiscal.entity.NotaFiscalMapper;
import br.com.organomeno.notaFiscal.itensNotaFiscal.ItensNotaFiscal;
import br.com.organomeno.notaFiscal.repository.NotaFiscalRepository;
import br.com.organomeno.scrapNotaFiscal.IdentificadorLayout;
import io.vertx.core.json.Json;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;


@ApplicationScoped
public class NotaFiscalServiceImpl implements NotaFiscalService{

    @Inject
    NotaFiscalRepository notaFiscalRepository;
    @Inject
    NotaFiscalMapper notaFiscalMapper;


    @Override
    public List<NotaFiscalDTO> filtrarNotaFiscal(NotaFiscalFiltroDTO notaFiscalFiltroDTO) {
        return notaFiscalMapper.toDtoList(notaFiscalRepository.filtrarNotasFiscais(notaFiscalFiltroDTO));
    }

    @Override
    @Transactional
    public Response inserirNotaFiscal(FileUpload htmlFile, String descricaoArquivo ) throws Exception{
        try {
            Document document = Jsoup.parse(htmlFile.uploadedFile().toFile());
            IdentificadorLayout identificadorLayout = new IdentificadorLayout(document);

            NotaFiscalDTO notaDTO = identificadorLayout.getLayout();
            NotaFiscal nota = notaFiscalMapper.toEntity(notaDTO);

            nota.setDescricao(descricaoArquivo);

            for(ItensNotaFiscal item : nota.getItensNotaFiscal()){
                item.setNotaFiscal(nota);
            }
            notaFiscalRepository.persist(nota);
            return Response.ok("Cadastrado com sucesso").build();

        }catch (Exception e){
            throw new Exception("Erro ao inserir Nota Fiscal" + e);
        }
    }
}
