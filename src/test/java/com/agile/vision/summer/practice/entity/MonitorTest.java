package com.agile.vision.summer.practice.entity;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import com.agile.vision.summer.practice.repositories.PcRepository;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.DataSetMergingStrategy;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBUnit(
        qualifiedTableNames = true,
        caseSensitiveTableNames = true,
        caseInsensitiveStrategy = Orthography.LOWERCASE,
        mergeDataSets = true,
        mergingStrategy = DataSetMergingStrategy.CLASS)
@DBRider
public class MonitorTest {


    @Autowired
    MonitorRepository monitorRepository;

    @Test
    @DataSet(value = "test.yml")
    public void shouldSeedUserDataSet() {
        assertThat(monitorRepository).isNotNull();
        assertThat(monitorRepository.count()).isEqualTo(2);
        assertThat(monitorRepository.findById(1).get().getPlace()).isNotNull();
        monitorRepository.delete(monitorRepository.findById(1).get());
    }

}
