<template>
  <div
    v-show="initRequestData"
    style="width: 100%;height: 100%"
    class="dataroom-chart-baseBar-wrapper"
  >
    <div
      :id="'chart' + config.code"
      style="width: 100%;height: 100%"
    />
  </div>
</template>

<script>
// 引入g2plot图表的公共方法
import g2plotMixins from '@gcpaas/data-room-ui/packages/components/G2Plots/js/mixins/g2plotMixins.js'
import mockData from './data.json'
export default {
  name: 'BaseBar',
  components: {},
  mixins: [g2plotMixins],
  props: {
  },
  data () {
    return {
      mockData,
      show: true
    }
  },
  computed: {},
  watch: {},
  created () {},
  mounted () {
  },
  methods: {
    updateChartStyle () {
      if (this.chart) {
        this.$nextTick(() => {
          // 确保 temporaryData 不为空
          if (this.temporaryData.length === 0) {
            console.warn('temporaryData is empty')
            return
          }
          // console.log(this.temporaryData)
          const index = this.config.option.index

          // 检查 index 的有效性
          if (index < 0 || index >= this.temporaryData.length) {
            console.warn(`Index ${index} is out of range. Max index is ${this.temporaryData.length - 1}`)
            return
          }

          // console.log(this.temporaryData[index][this.config.dataSource.metricField])
          // const value = Object.values(this.temporaryData[index])[0]
          const value = this.temporaryData[index][this.config.dataSource.metricField]

          // 确保 value 是有效的数字
          if (typeof value === 'number' && !isNaN(value)) {
            this.config.option.percent = value
          } else {
            console.warn('Invalid value for percent:', value)
          }

          const option = {
            ...this.config.option,
            data: this.temporaryData
          }

          // 更新图表
          this.chart.update(option)
          this.$forceUpdate()
        })
      } else {
        console.warn('Chart instance is not available')
      }
    }
  }
}
</script>

<style scoped lang="scss">
</style>
