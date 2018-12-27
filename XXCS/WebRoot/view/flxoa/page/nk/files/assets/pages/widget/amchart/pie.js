(function() {

})();
(function() {

	var k = window.AmCharts;
	k.AmPieChart = k.Class({
		inherits: k.AmSlicedChart,
		construct: function(a) {
			this.type = "pie";
			k.AmPieChart.base.construct.call(this, a);
			this.cname = "AmPieChart";
			this.pieBrightnessStep = 30;
			this.minRadius = 10;
			this.depth3D = 0;
			this.startAngle =  90;
			this.angle = this.innerRadius = 0;
			this.startRadius = "500%";
			this.pullOutRadius = "20%";
			this.labelRadius = 20;
			this.labelText = "[[title]]: [[percents]]%";
			this.balloonText = "[[title]]: [[percents]]% ([[value]])\n[[description]]";
			this.previousScale = 1;
			this.adjustPrecision = !1;
			this.gradientType = "radial";
			k.applyTheme(this, a, this.cname)
		},
		drawChart: function() {
			k.AmPieChart.base.drawChart.call(this);
			var a = this.chartData;
			if (k.ifArray(a)) {
				if (0 < this.realWidth && 0 < this.realHeight) {
					k.VML && (this.startAlpha = 1);
					var b = this.startDuration,
						c = this.container,
						d = this.updateWidth();
					this.realWidth = d;
					var g = this.updateHeight();
					this.realHeight = g;
					var f = k.toCoordinate,
						h = f(this.marginLeft, d),
						e = f(this.marginRight, d),
						z = f(this.marginTop, g) + this.getTitleHeight(),
						n = f(this.marginBottom, g) + this.depth3D,
						A, B, m, w = k.toNumber(this.labelRadius),
						q = this.measureMaxLabel();
					q > this.maxLabelWidth && (q = this.maxLabelWidth);
					this.labelText && this.labelsEnabled || (w = q = 0);
					A = void 0 === this.pieX ? (d - h - e) / 2 + h : f(this.pieX, this.realWidth);
					B = void 0 === this.pieY ? (g - z - n) / 2 + z : f(this.pieY, g);
					m = f(this.radius, d, g);
					m || (d = 0 <= w ? d - h - e - 2 * q : d - h - e, g = g - z - n, m = Math.min(d, g), g < d && (m /= 1 - this.angle / 90, m > d && (m = d)), g = k.toCoordinate(this.pullOutRadius, m), m = (0 <= w ? m - 1.8 * (w + g) : m - 1.8 * g) / 2);
					m < this.minRadius && (m = this.minRadius);
					g = f(this.pullOutRadius, m);
					z = k.toCoordinate(this.startRadius, m);
					f = f(this.innerRadius, m);
					f >= m && (f = m - 1);
					n = k.fitToBounds(this.startAngle, 0, 360);
					0 < this.depth3D && (n = 270 <= n ? 270 : 90);
					n -= 90;
					360 < n && (n -= 360);
					d = m - m * this.angle / 90;
					for (h = q = 0; h < a.length; h++) e = a[h], !0 !== e.hidden && (q += k.roundTo(e.percents, this.pf.precision));
					q = k.roundTo(q, this.pf.precision);
					this.tempPrec = NaN;
					this.adjustPrecision && 100 != q && (this.tempPrec = this.pf.precision + 1);
					for (var E, h = 0; h < a.length; h++) if (e = a[h], !0 !== e.hidden && (this.showZeroSlices || 0 !== e.percents)) {
						var r = 360 * e.percents / 100,
							q = Math.sin((n + r / 2) / 180 * Math.PI),
							C = d / m * -Math.cos((n + r / 2) / 180 * Math.PI),
							p = this.outlineColor;
						p || (p = e.color);
						var u = this.alpha;
						isNaN(e.alpha) || (u = e.alpha);
						p = {
							fill: e.color,
							stroke: p,
							"stroke-width": this.outlineThickness,
							"stroke-opacity": this.outlineAlpha,
							"fill-opacity": u
						};
						e.url && (p.cursor = "pointer");
						p = k.wedge(c, A, B, n, r, m, d, f, this.depth3D, p, this.gradientRatio, e.pattern, this.path, this.gradientType);
						k.setCN(this, p, "pie-item");
						k.setCN(this, p.wedge, "pie-slice");
						k.setCN(this, p, e.className, !0);
						this.addEventListeners(p, e);
						e.startAngle = n;
						a[h].wedge = p;
						0 < b && (this.chartCreated || p.setAttr("opacity", this.startAlpha));
						e.ix = q;
						e.iy = C;
						e.wedge = p;
						e.index = h;
						e.label = null;
						u = c.set();
						if (this.labelsEnabled && this.labelText && e.percents >= this.hideLabelsPercent) {
							var l = n + r / 2;
							0 > l && (l += 360);
							360 < l && (l -= 360);
							var t = w;
							isNaN(e.labelRadius) || (t = e.labelRadius, 0 > t && (e.skipTick = !0));
							var r = A + q * (m + t),
								D = B + C * (m + t),
								x, v = 0;
							isNaN(E) && 350 < l && 1 < a.length - h && (E = h - 1 + Math.floor((a.length - h) / 2));
							if (0 <= t) {
								var y;
								90 >= l && 0 <= l ? (y = 0, x = "start", v = 8) : 90 <= l && 180 > l ? (y = 1, x = "start", v = 8) : 180 <= l && 270 > l ? (y = 2, x = "end", v = -8) : 270 <= l && 354 >= l ? (y = 3, x = "end", v = -8) : 354 <= l && (h > E ? (y = 0, x = "start", v = 8) : (y = 3, x = "end", v = -8));
								e.labelQuarter = y
							} else x = "middle";
							l = this.formatString(this.labelText, e);
							(t = this.labelFunction) && (l = t(e, l));
							t = e.labelColor;
							t || (t = this.color);
							"" !== l && (l = k.wrappedText(c, l, t, this.fontFamily, this.fontSize, x, !1, this.maxLabelWidth), k.setCN(this, l, "pie-label"), k.setCN(this, l, e.className, !0), l.translate(r + 1.5 * v, D), 0 > w && (l.node.style.pointerEvents = "none"), l.node.style.cursor = "default", e.ty = D, e.textX = r + 1.5 * v, u.push(l), this.axesSet.push(u), e.labelSet = u, e.label = l, this.addEventListeners(u, e));
							e.tx = r;
							e.tx2 = r + v;
							e.tx0 = A + q * m;
							e.ty0 = B + C * m
						}
						r = f + (m - f) / 2;
						e.pulled && (r += g);
						this.accessible && this.accessibleLabel && (D = this.formatString(this.accessibleLabel, e), this.makeAccessible(p, D));
						void 0 !== this.tabIndex && p.setAttr("tabindex", this.tabIndex);
						e.balloonX = q * r + A;
						e.balloonY = C * r + B;
						e.startX = Math.round(q * z);
						e.startY = Math.round(C * z);
						e.pullX = Math.round(q * g);
						e.pullY = Math.round(C * g);
						this.graphsSet.push(p);
						if (0 === e.alpha || 0 < b && !this.chartCreated) p.hide(), u && u.hide();
						n += 360 * e.percents / 100;
						360 < n && (n -= 360)
					}
					0 < w && this.arrangeLabels();
					this.pieXReal = A;
					this.pieYReal = B;
					this.radiusReal = m;
					this.innerRadiusReal = f;
					0 < w && this.drawTicks();
					this.initialStart();
					this.setDepths()
				}(a = this.legend) && a.invalidateSize()
			} else this.cleanChart();
			this.dispDUpd()
		},
		setDepths: function() {
			var a = this.chartData,
				b;
			for (b = 0; b < a.length; b++) {
				var c = a[b],
					d = c.wedge,
					c = c.startAngle;
				0 <= c && 180 > c ? d.toFront() : 180 <= c && d.toBack()
			}
		},
		arrangeLabels: function() {
			var a = this.chartData,
				b = a.length,
				c, d;
			for (d = b - 1; 0 <= d; d--) c = a[d], 0 !== c.labelQuarter || c.hidden || this.checkOverlapping(d, c, 0, !0, 0);
			for (d = 0; d < b; d++) c = a[d], 1 != c.labelQuarter || c.hidden || this.checkOverlapping(d, c, 1, !1, 0);
			for (d = b - 1; 0 <= d; d--) c = a[d], 2 != c.labelQuarter || c.hidden || this.checkOverlapping(d, c, 2, !0, 0);
			for (d = 0; d < b; d++) c = a[d], 3 != c.labelQuarter || c.hidden || this.checkOverlapping(d, c, 3, !1, 0)
		},
		checkOverlapping: function(a, b, c, d, g) {
			var f, h, e = this.chartData,
				k = e.length,
				n = b.label;
			if (n) {
				if (!0 === d) for (h = a + 1; h < k; h++) e[h].labelQuarter == c && (f = this.checkOverlappingReal(b, e[h], c)) && (h = k);
				else for (h = a - 1; 0 <= h; h--) e[h].labelQuarter == c && (f = this.checkOverlappingReal(b, e[h], c)) && (h = 0);
				!0 === f && 200 > g && isNaN(b.labelRadius) && (f = b.ty + 3 * b.iy, b.ty = f, n.translate(b.textX, f), this.checkOverlapping(a, b, c, d, g + 1))
			}
		},
		checkOverlappingReal: function(a, b, c) {
			var d = !1,
				g = a.label,
				f = b.label;
			a.labelQuarter != c || a.hidden || b.hidden || !f || (g = g.getBBox(), c = {}, c.width = g.width, c.height = g.height, c.y = a.ty, c.x = a.tx, a = f.getBBox(), f = {}, f.width = a.width, f.height = a.height, f.y = b.ty, f.x = b.tx, k.hitTest(c, f) && (d = !0));
			return d
		}
	})
})();