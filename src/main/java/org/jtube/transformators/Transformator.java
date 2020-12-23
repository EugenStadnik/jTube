package org.jtube.transformators;

import org.jtube.data.SourceData;
import org.jtube.data.result.ProductData;

public interface Transformator {

	ProductData transform(SourceData sourceData);

}
