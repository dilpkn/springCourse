НЕОБХОДИМЫЕ ФАЙЛЫ ДЛЯ КОНФИГУРАЦИИ SPRING MVC ПРИЛОЖЕНИЯ 

СТРУКТУРА ФАЙЛОВ:


<img width="591" height="496" alt="image" src="https://github.com/user-attachments/assets/148457d4-c130-4773-8f58-7d030fa9e697" />


добавить в сервлет иницилайзер, чтобы работать с разными методами CRUD

  //для фильтра для patch, delete
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
