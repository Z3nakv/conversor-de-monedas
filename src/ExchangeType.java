import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record ExchangeType( @SerializedName("base_code")
                            String base_code,
                           @SerializedName("conversion_rates")
                           Map<String, Double> conversionRates) {
}
