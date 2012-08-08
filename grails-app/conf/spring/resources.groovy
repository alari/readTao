import readTao.ApplicationContextHolder

// Place your Spring DSL code here
beans = {
    applicationContextHolder(ApplicationContextHolder) { bean ->
        bean.factoryMethod = 'getInstance'
    }
}
