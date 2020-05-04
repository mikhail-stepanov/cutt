package ru.stepanov.core.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.stepanov.core.interfaces.IClearService;
import ru.stepanov.core.models.SettingsInformation;
import ru.stepanov.core.services.SettingsService;

@RestController
public class MicroserviceInformationEndpoint {

    @Autowired(required = false)
    IClearService clearService;

    @Autowired(required = false)
    SettingsService settingsServices;

    @RequestMapping("common/settings")
    public SettingsInformation[] settings() {
        return settingsServices.settingsInformations();
    }

    @RequestMapping("common/dictionaries")
    public SettingsInformation[] dictionaries() {
        return settingsServices.settingsInformations();
    }

    @RequestMapping(value = "common/clear", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public void clear() {
        if (clearService != null)
            clearService.clear();
    }
}
