import readTao.ApplicationContextHolder
import readTao.ReadTaoService

class BootStrap {

    def init = { servletContext ->
        ReadTaoService readTaoService = (ReadTaoService)ApplicationContextHolder.getBean("readTaoService")
        readTaoService.loadBooks()
    }
    def destroy = {
    }
}
