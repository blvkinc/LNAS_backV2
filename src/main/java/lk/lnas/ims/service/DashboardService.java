package lk.lnas.ims.service;

import lk.lnas.ims.repos.DashboardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public BigDecimal getTotalSales() {
        return dashboardRepository.calculateTotalSales();
    }

    public BigDecimal getTotalProduction() {
        return dashboardRepository.calculateTotalProduction();
    }

    public BigDecimal getTotalCount() {
        return dashboardRepository.calculateTotalCount();
    }

    public BigDecimal getTotalFarms() {
        return dashboardRepository.calculateTotalFarms();
    }

    public BigDecimal getMonthlySales() {
        return dashboardRepository.calculateMonthlySales();
    }

    public BigDecimal getMonthlyProduction() {
        return dashboardRepository.calculateMonthlyProduction();
    }

    public BigDecimal getMonthlyPlantCount() {
        return dashboardRepository.calculateMonthlyPlantCount();
    }

    public BigDecimal getActiveFarmsCount() {
        return dashboardRepository.calculateActiveFarmsCount();
    }

    public List<Object[]> getWeeklySales() {
        LocalDateTime currentDate = LocalDateTime.now();
        YearMonth yearMonth = YearMonth.from(currentDate);
        LocalDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59);
        return dashboardRepository.calculateWeeklySales(firstDayOfMonth, lastDayOfMonth);
    }

    public List<Object[]> getWeeklyPurchase() {
        LocalDateTime currentDate = LocalDateTime.now();
        YearMonth yearMonth = YearMonth.from(currentDate);
        LocalDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59);
        return dashboardRepository.calculateWeeklyPurchase(firstDayOfMonth, lastDayOfMonth);
    }

    public List<Object[]> getMonthlyProductionByFarm() {
        OffsetDateTime currentDate = OffsetDateTime.now();
        YearMonth yearMonth = YearMonth.from(currentDate.toLocalDate());
        OffsetDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay().atOffset(currentDate.getOffset());
        OffsetDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59).atOffset(currentDate.getOffset());
        return dashboardRepository.calculateMonthlyProductionByFarm(firstDayOfMonth, lastDayOfMonth);
    }

    public List<Object[]> getMonthlyProductionByWeek() {
        OffsetDateTime currentDate = OffsetDateTime.now();
        YearMonth yearMonth = YearMonth.from(currentDate.toLocalDate());
        OffsetDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay().atOffset(currentDate.getOffset());
        OffsetDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59).atOffset(currentDate.getOffset());
        return dashboardRepository.calculateMonthlyProductionByWeek(firstDayOfMonth, lastDayOfMonth);
    }

}
