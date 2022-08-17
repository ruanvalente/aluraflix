package com.aluraflix.backend.config.seed;

import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class SeedingDatabase implements CommandLineRunner {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void run(String... args) throws Exception {
        Video video1 = new Video(null, "Estrutura de Dados com Java | Lista Encadeada | Introdução", "Curso de Estrutura de Dados com Java - Lista Encadeada (Lista Ligada): vídeo de introdução do módulo, criação das classes no Java e adicionando um elemento na lista encadeada", "https://www.youtube.com/watch?v=RW0oD2L_tSg");
        Video video2 = new Video(null, "Nest.js com Domain Driven Design (DDD)", "Entre os dias 15 a 22 de Agosto vai rolar a Imersão Full Stack & Full Cycle, um evento online e 100% gratuito onde eu vou te mostrar como trabalhar com aplicações de grande porte e ter um dos perfis mais desejados e bem pagos do mercado.", "https://www.youtube.com/watch?v=XTmvAj5OSQI");
        Video video3 = new Video(null, "Intellij e Java - Tutorial como usar em 2022-2 - Integrado JDK WSL Linux", "Introdução ao Intellij para Java", "https://www.youtube.com/watch?v=0_e9Egeyk2E");
        Video video4 = new Video(null, "Como Funciona Sockets, Cliente, Servidor e a Web? | Introdução a Redes Parte 4", "Agora que todo mundo sabe como funciona o básico de rede, vamos ver como funciona o básico de aplicações de rede, o que são sockets, pra que eles servem.", "https://www.youtube.com/watch?v=lc6U93P4Sxw");
        Video video5 = new Video(null, "DevOps na Vida Real - Jeferson Noronha", "Jeferson Noronha, Lead DevOps Engineer da Produban fala sobre DevOps na Vida Real.", "https://www.youtube.com/watch?v=KbvfV01tSig");
        Video video6 = new Video(null, "Governança, Qualidade de Dados e NoSQL: dá para combinar? - Danielle Monteiro", "Danielle Monteiro, Senior Data Architect da B3, fala sobre Governança, Qualidade de Dados e NoSQL: dá para combinar?no iMasters InterCon 2017.", "https://www.youtube.com/watch?v=DZRBV6FjuSw");

        videoRepository.saveAll(Arrays.asList(video1, video2, video3, video4, video5, video6));
    }
}
