<img width="1407" height="1076" alt="image" src="https://github.com/user-attachments/assets/323ffa40-5fd5-425b-b2e9-ba9c2e46ded9" />

<img width="1387" height="1079" alt="image" src="https://github.com/user-attachments/assets/5c7cd510-d4e7-4433-85cf-1bf82400bda5" />

<img width="1415" height="1075" alt="image" src="https://github.com/user-attachments/assets/d380ce13-edb5-4ceb-8f4b-6e92772e7504" />
можем использовать таймлифовский метод патч
<form th:method="PATCH" th:action="@{/people}" th:object ="${person}">


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
