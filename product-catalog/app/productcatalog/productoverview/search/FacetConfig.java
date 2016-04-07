package productcatalog.productoverview.search;

import io.sphere.sdk.models.Base;

import javax.annotation.Nullable;
import java.util.Optional;

public class FacetConfig extends Base {

    private final SunriseFacetType type;
    private final String key;
    private final String label;
    private final String attrPath;
    private final boolean countHidden;
    private final boolean matchingAll;
    private final boolean multiSelect;
    private final Optional<Long> limit;
    private final Optional<Long> threshold;
    private final Optional<FacetMapperConfig> mapperConfig;

    private FacetConfig(final SunriseFacetType type, final String key, final String label, final String attrPath,
                        final boolean countHidden, final boolean matchingAll, final boolean multiSelect,
                        @Nullable final Long limit, @Nullable final Long threshold, @Nullable final FacetMapperConfig mapperConfig) {
        this.type = type;
        this.key = key;
        this.label = label;
        this.attrPath = attrPath;
        this.countHidden = countHidden;
        this.matchingAll = matchingAll;
        this.multiSelect = multiSelect;
        this.limit = Optional.ofNullable(limit);
        this.threshold = Optional.ofNullable(threshold);
        this.mapperConfig = Optional.ofNullable(mapperConfig);
    }

    public SunriseFacetType getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }

    public String getAttrPath() {
        return attrPath;
    }

    public boolean isCountHidden() {
        return countHidden;
    }

    public boolean isMatchingAll() {
        return matchingAll;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public Optional<Long> getLimit() {
        return limit;
    }

    public Optional<Long> getThreshold() {
        return threshold;
    }

    public Optional<FacetMapperConfig> getMapperConfig() {
        return mapperConfig;
    }

    public static FacetConfig of(final SunriseFacetType type, final String key, final String label, final String attrPath,
                                 final boolean countHidden, final boolean matchingAll, final boolean multiSelect,
                                 @Nullable final Long limit, @Nullable final Long threshold, @Nullable final FacetMapperConfig mapperConfig) {
        return new FacetConfig(type, key, label, attrPath, countHidden, matchingAll, multiSelect, limit, threshold, mapperConfig);
    }

    public static FacetConfig of(final SunriseFacetType type, final String key, final String label, final String attrPath,
                                 final boolean countHidden, final boolean matchingAll, final boolean multiSelect) {
        return new FacetConfig(type, key, label, attrPath, countHidden, matchingAll, multiSelect, null, null, null);
    }
}
