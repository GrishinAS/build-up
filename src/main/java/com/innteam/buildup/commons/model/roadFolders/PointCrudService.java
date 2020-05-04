package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.ContentType;
import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import com.innteam.buildup.commons.model.paper.Content;
import java.util.Set;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PointCrudService extends DomainObjectCrudServiceBase<RoadPoint> {
    @Autowired
    RoadFolderCrudService folderCrudService;

    public PointCrudService(PagingAndSortingRepository<RoadPoint, UUID> repo) {
        super(repo);
    }

    public List<RoadPoint> getMock() {
        //road mock
        List<RoadPoint> result = new ArrayList<>();
        fillMocks(result);
        RoadFolder folder = new RoadFolder("Java", result);

        UUID uuid = folderCrudService.create(folder);

        //check
        folderCrudService.read(uuid);
        return folder.getInternal();
    }

    private void fillMocks(List<RoadPoint> result) {
        Set<Content> gitContent = Set.of(new Content(ContentType.COURSE, "githowto.com", "Git How To — это интерактивный тур, который познакомит вас с основами Git."
                                                                                         + " Тур создан с пониманием того, что лучшим способом научиться чему-нибудь — сделать это своими руками.", "https://githowto.com", 7200));
        result.add(new RoadPoint("Git и Github", "Git — мощная и сложная распределенная система контроля версий. "
                                                 + "Понимание всех возможностей git открывает для разработчика новые горизонты в управлении исходным кодом. ", gitContent));
        Set<Content> linuxContent = Set.of(
        new Content(ContentType.BOOK, "Администрирование GNU/Linux с нуля", "Дается необходимый набор знаний в области администрирования GNU/Linux. Материал не привязан к какому-либо конкретному дистрибутиву GNU/Linux, а рассмотрены общие процедуры организации и поддержки этих систем: работа в оболочке Bash, утилиты командной строки, файловые системы, управление загрузкой, системные и сетевые службы GNU/ Linux. Приводится множество примеров, связанных с решением повседневных задач системного администрирования Материал подобран так, чтобы читатель имел возможность подготовиться к сдаче сертификационных экзаменов Linux Professional Institute LPI-101 и LPI-102.", "https://www.litres.ru/aleksey-beresnev/administrirovanie-gnu-linux-s-nulya/", 7200),
        new Content(ContentType.VIDEO, "Изучаем Linux на примере UBUNTU", "Видео курс. Изучаем работу в операционной системе Linux на примере дистрибутива Ubuntu, учим терминал, и работу в ОС.", "https://www.youtube.com/playlist?list=PL7KBbsb4oaOnEdCxwKkRDXCUNZ-gPYf89", 7200));
        result.add(new RoadPoint("Linux", "Линукс (от англ. «Linux») — это операционная система на основе Unix-подобных систем, включающая утилиты GNU. Распространяется бесплатно.\n"
                                          + "Главная «фишка» операционной системы Линукс в том, что она бесплатна в соответствии с GNU (свободного и открытого программного обеспечения. ", linuxContent));

        Set<Content> algoFrameContent = Set.of(
        new Content(ContentType.PAPER, "Объяснение алгоритмов сортировки с примерами на Java", "В этой статье будут рассмотрены популярные алгоритмы, принципы их работы и реализация на Java. А ещё сравним, как быстро они сортируют элементы в списке.", "https://tproger.ru/translations/sorting-algorithms-in-python/", 2000),
        new Content(ContentType.VIDEO, "Алгоритмы и структуры данных. Подготовительный курс", "Цель курса — ознакомить слушателей с основными алгоритмами, применяемыми для разработки программного обеспечения. Научить выбирать подходящие структуры данных и алгоритмы для реализации возникающих задач. ", "https://www.youtube.com/playlist?list=PLrCZzMib1e9pDxHYzmEzMmnMMUK-dz0_7", 14200),
        new Content(ContentType.PAPER, "Java web-фреймворки", "Несомненно, Java сейчас является одним из самых популярных языков, для него существует множество подключаемых инструментов. Мы подготовили для вас подборку web-фреймворков для Java, которые облегчат вам разработку сайтов.", "https://tproger.ru/digest/java-web-frameworks/", 4200));
        result.add(new RoadPoint("Алгоритмы и фреймворки", "Алгоритмы и фреймворки крайне необходимы хорошему программисту.", algoFrameContent));

        Set<Content> jdkContent = Set.of(new Content(ContentType.PAPER, "Что такое JDK, JRE и JVM в Java?", "Большинство начинающих Java программистов сразу начинают изучать основные конструкции языка, синтаксис и правила не задумываясь о том, что такое JDK, JRE и JVM. Они просто упускают этот вопрос так и не разобравшись чем отличаются и для чего предназначены JDK, JRE и JVM. Поэтому в этой статье я попытаюсь объяснить разницу между этими концепциями языка Java.", "https://javadevblog.com/chto-takoe-jdk-jre-i-jvm-v-java.html", 3200));
        result.add(new RoadPoint("JDK API", "Большинство начинающих Java программистов сразу начинают изучать основные конструкции языка, синтаксис и правила не задумываясь о том, что такое JDK, JRE и JVM. Они просто упускают этот вопрос так и не разобравшись чем отличаются и для чего предназначены JDK, JRE и JVM.", jdkContent));

        Set<Content> collectionsContent = Set.of(new Content(ContentType.PAPER, "Справочник по Java Collections Framework", "Данная публикация не является полным разбором или анализом (не покрывает пакет java.util.concurrent). Это, скорее, справочник, который поможет начинающим разработчикам понять ключевые отличия одних коллекций от других, а более опытным разработчикам просто освежить материал в памяти.", "https://javadevblog.com/chto-takoe-jdk-jre-i-jvm-v-java.html", 3200));
        result.add(new RoadPoint("Java Collections Framework", "Java Collection Framework — иерархия интерфейсов и их реализаций, которая является частью JDK и позволяет разработчику пользоваться большим количесвом структур данных из «коробки».", collectionsContent));
        result.add(new RoadPoint("Java Concurrency", "Java изначально разработана с поддержкой параллельного программирования, а начиная с версии 5.0, язык включает высокоуровневые API для параллельных потоков. Так что грамотный Java-разработчик просто обязан хорошо разбираться в многопоточности и иметь представление об основных API из пакетов java.util.concurrent.", collectionsContent));
        result.add(new RoadPoint("Java IO", "IO API – (Input & Output) в первую очередь это Java API, которые облегчают работу с потоками.", collectionsContent));
        result.add(new RoadPoint("Функции Java 8", "Добро пожаловать в ведение по Java 8. Этот материал шаг за шагом познакомит вас со всеми новыми фичами языка. Вы научитесь использовать методы интерфейсов по умолчанию (default interface methods), лямбда-выражения (lambda expressions), ссылки на методы (method references) и повторяемые аннотации (repeatable annotations).", collectionsContent));
        result.add(new RoadPoint("Spring, Spring Boot, Hibernate", "Spring, Spring Boot, Hibernate — иерархия фреймворков и их реализаций, которая является частью JDK и позволяет разработчику пользоваться большим количесвом структур данных из «коробки».", collectionsContent));

    }
}
