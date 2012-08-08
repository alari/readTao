package readTao

import org.springframework.core.io.ClassPathResource

class ReadTaoService {

    static transactional = false

    List<Chapter> book = []

    void loadBooks() {
        File bookFile = new ClassPathResource("tao_ru.txt", ReadTaoService.class).getFile();

        Chapter current
        int i=0

        // TODO: generate clean markup for a book
        // TODO: recognize book language

        bookFile.eachLine {
            if(it.startsWith("<ul>")) {
                if(current) {
                    book.add(current)
                }
                current = new Chapter(
                        title: ++i,
                        text: ""
                )
                return;
            }
            if(!it) return;
            if(it.startsWith("    ")) {
                current.text += "\n"
            }
            current.text += it.trim()
        }
        book.add(current)
    }

    Chapter getCurrentChapter(int chapterNum) {
        if(chapterNum >= book.size() || chapterNum < 0) chapterNum = 0
        book.get(chapterNum)
    }

    int getNext(int chapterNum) {
        if(chapterNum >= book.size() || chapterNum < 0) chapterNum = 0
        chapterNum+1
    }
}
