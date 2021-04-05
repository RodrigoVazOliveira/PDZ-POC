package br.dev.rvz.pombo.dto.contato;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.domain.Perfil;

public class GravarContato {

    private Perfil perfil;
    private Long idConta;
    private Boolean bloqueio;

    public GravarContato() {
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Boolean getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(Boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    public Contato converterDtoParaContato() {
        Contato contato = new Contato();
        contato.setPerfil(this.perfil);
        Conta conta = new Conta();
        conta.setId(this.idConta);
        contato.setConta(conta);
        contato.setBloqueio(this.bloqueio);

        return contato;
    }
}
