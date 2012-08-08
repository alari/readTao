package readTao

import javax.servlet.http.Cookie

class RootController {

    def readTaoService

    private final String COOKIE_LAST = 'last_chapter'
    private final String COOKIE_NEXT = 'next_chapter'
    private final int COOKIE_NEXT_MAX_AGE = 4

    private boolean isNextChapterLocked() {
        g.cookie(name: COOKIE_NEXT) ? true : false
    }

    private int getLastViewedChapterNum() {
        String c = g.cookie(name: COOKIE_LAST).toString()
        c ? Integer.parseInt(c) : 0
    }

    def index() {
        Chapter current = readTaoService.getCurrentChapter(lastViewedChapterNum)
        [title: current.title, text: current.text, canMove: !nextChapterLocked]
    }

    def next() {
        if (nextChapterLocked) {
            redirect action: "index"
            return;
        }
        int lastCh = readTaoService.getNext(lastViewedChapterNum)

        Cookie cookieLast = new Cookie(COOKIE_LAST,lastCh.toString())
        response.addCookie(cookieLast)

        Cookie cookieNext = new Cookie(COOKIE_NEXT, "1")
        cookieNext.maxAge = COOKIE_NEXT_MAX_AGE
        response.addCookie(cookieNext)

        redirect action: "index"
    }

    def error() {
        redirect uri: "/"
    }
}
