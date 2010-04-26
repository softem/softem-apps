package jp.co.softem.apps.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting(
            "/{app}/{sub}/edit/{key}/{version}",
            "/{app}/{sub}/edit?key={key}&version={version}");
        addRouting(
            "/{app}/{sub}/delete/{key}/{version}",
            "/{app}/{sub}/delete?key={key}&version={version}");
    }
}
